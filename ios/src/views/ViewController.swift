import UIKit
import core

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Kotlin Welcome message
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = Welcome().createApplicationScreenMessage()
        view.addSubview(label)
        
        // Downloader
        let speedTest = SpeedTest(client: HttpClient())
        speedTest.testProgress =  { (message: String) -> KotlinUnit in
            print("SpeedTest - \(message)")
            return KotlinUnit()
        }
        speedTest.simpleTest()
    }
}

