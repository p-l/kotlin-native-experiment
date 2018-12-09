import UIKit
import core

class ViewController: UIViewController {
    private var speedLabel: UILabel?


    override func viewDidLoad() {
        super.viewDidLoad()

        // Kotlin Welcome message
        let welcomeLabel = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        welcomeLabel.center = CGPoint(x: 160, y: 285)
        welcomeLabel.textAlignment = .center
        welcomeLabel.font = welcomeLabel.font.withSize(25)
        welcomeLabel.text = Welcome().createApplicationScreenMessage()
        view.addSubview(welcomeLabel)


        // Sppeed Update
        speedLabel = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        if let label = speedLabel {
            label.center = CGPoint(x: welcomeLabel.center.x, y: welcomeLabel.center.y + welcomeLabel.frame.height)
            label.textAlignment = .center
            label.font = label.font.withSize(25)
            label.text = String(format:"%6.2f kpbs", arguments: [0.0])
            view.addSubview(label)
        }

        // Downloader
        let speedTest = SpeedTest(client: HttpClient())
        speedTest.testProgressString =  { (message: String) -> KotlinUnit in
            print("SpeedTest - \(message)")
            return KotlinUnit()
        }
        speedTest.testKbpsSpeedUpdate = { (speedKbps : KotlinDouble) -> KotlinUnit in
            DispatchQueue.main.async {
                if let label = self.speedLabel {
                    label.text = String(format:"%6.2f kpbs", arguments: [speedKbps.toDouble()])
                }
            }
            return KotlinUnit()
        }

        speedTest.simpleTest()
    }
}

