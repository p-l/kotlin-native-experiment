package shared.core

interface HttpClientInterface {

    //TODO: Provide interface for file parsing
    // var successHandler: ((Data) -> Unit)?

    var errorHandler: ((Error) -> Unit)?

    // Progress as 0.0 to 1.0
    var progressHandler: ((Double) -> Unit)?

    // Prepare the operation
    fun prepare(targetURL: String)

    // Start the download
    fun start()
}