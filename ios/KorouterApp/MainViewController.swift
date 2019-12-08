import UIKit
import korouter

class MainViewController: UIViewController, Presenter {
    func onSwapInChild(name: String?, child: Presenter?, args: [String : String]?) {
        NSLog("swap in")
    }

    func onSwapOutChild(name: String?, child: Presenter?) {
        NSLog("swap out")
    }

    lazy var router: KoRouter = KoRouter.Companion().invoke { builder in
        builder.route(path: "/") { builder in
            builder.name = "index"
            builder.component = self
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
//        label.text = Proxy().proxyHello()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
