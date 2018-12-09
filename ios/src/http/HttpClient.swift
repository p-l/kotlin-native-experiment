import UIKit
import core

class HttpClient : NSObject, HttpClientInterface  {
    private var downloadTask : DownloadTask?

    var errorHandler: ((KotlinError) -> KotlinUnit)?
    var progressHandler: ((KotlinDouble) -> KotlinUnit)?

    // TODO: Move to Kotlin code
    var successHandler: ((Data) -> Void)?
    
    func prepare(targetURL: String) {
        let downloadURL = URL(string: targetURL)!
        let downloadRequest = URLRequest(url:downloadURL, cachePolicy: .reloadIgnoringLocalCacheData, timeoutInterval: 30)
        
        downloadTask = DownloadService.shared.download(request: downloadRequest)
        if var task = downloadTask {
            task.completionHandler = { [weak self] in
            switch $0 {
                case .failure(let error):
                    print("HttpClient - \(error)")
                    if let handler = self?.errorHandler {
                        let kotlinError = KotlinError(message: error.localizedDescription)
                        _ = handler(kotlinError)
                    }
                case .success(let data):
                    print("HttpClient - Number of bytes: \(data.count)")
                    if let handler = self?.successHandler {
                        handler(data)
                    }
                }
            }
            task.progressHandler = { [weak self] in
                let progress = $0
                let progressPercentage = progress*1000
                print("HttpClient - Progress: \(progressPercentage.rounded()/10)%")
                if let handler = self?.progressHandler {
                    _ = handler(progress.toKotlinDouble())
                }
            }
        }
    }
    
    
    func start() {
        if let task = downloadTask {
            task.resume()
        }
    }
}
