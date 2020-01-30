import UIKit
import korouter

class MainViewController: UIViewController {
    @IBOutlet weak var containerView: UIView!

    override func viewDidLoad() {
        super.viewDidLoad()

        let router: KoRouter = KoRouter {
            $0.route(path: "") {
                $0.name = "index"
                $0.component = self as Presenter

                $0.children {
                    $0.route(path: "/") {
                        $0.name = "index"
                        let vc = self.storyboard?.instantiateViewController(withIdentifier: "TopViewController")
                        $0.component = vc as! Presenter
                    }

                    $0.route(path: "list") {
                        $0.name = $0.path
                        let vc = self.storyboard?.instantiateViewController(withIdentifier: "ItemListViewController")
                        $0.component = vc as! Presenter
                    }
                }
            }
        }
        Router.initialize(router)

        Router.get().push(location: "/")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}

extension MainViewController: Presenter {
    func onSwapInChild(name: String?, child: Presenter?, args: [String : String]?) {
        guard let _child = child as? UIViewController else {
            NSLog("\(type(of: self)) swap in child: (name:\(name ?? "null"), child:null)")
            return
        }

        NSLog("\(type(of: self)) swap in child: (name:\(name ?? "null"), child:\(_child))")

        /// childVC.view insert or swap into containerView
        self.changeContent(containerView: self.containerView, childVC: _child)
    }

    func onSwapOutChild(name: String?, child: Presenter?) {
        guard let _child = child as? UIViewController else {
            NSLog("\(type(of: self)) swap out child: (name:\(name ?? "null"), child:null)")
            return
        }
        NSLog("\(type(of: self)) swap out child: (name:\(name ?? "null"), child:\(_child))")
    }
}
