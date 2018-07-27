import br.com.labbs.workout.httpclientbattle.shared.Env
import br.com.labbs.workout.httpclientbattle.shared.HttpClient
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder

class ApacheHttpClient() : HttpClient<HttpGet, HttpResponse, CloseableHttpClient> {

    private var client: CloseableHttpClient = HttpClientBuilder.create().build()

    override fun newRequest() = HttpGet(Env.URL_SERVER.get())

    override fun execRequest(request: HttpGet?, number: Int) = client.execute(request)

    override fun getClientName() = CLIENT_NAME

    override fun getResponseStatusCode(response: HttpResponse?) = response?.statusLine?.statusCode ?: 500

    override fun addHeaderToRequest(request: HttpGet?, key: String?, value: String?) {
        request?.addHeader(key, value)
    }

    companion object {

        const val CLIENT_NAME = "ApacheHttpClient"

    }

}