import UIKit
import korouter

class MainViewController: UIViewController, Presenter {
    @IBOutlet weak var containerView: UIView!

    func onSwapInChild(name: String?, child: Presenter?, args: [String : String]?) {
        NSLog("swap in")
        if (child == nil) { return }
        self.changeContent(containerView: self.containerView, childVC: child as! UIViewController)
    }

    func onSwapOutChild(name: String?, child: Presenter?) {
        NSLog("swap out")
    }

    lazy var router: KoRouter = KoRouter.Companion().invoke {
        $0.route(path: "") {
            $0.name = "index"
            $0.component = self as Presenter

            $0.children {
                $0.route(path: "/") {
                    $0.name = "index"
                    let vc = self.storyboard?.instantiateViewController(withIdentifier: "TopViewController")
                    $0.component = vc as! Presenter
                }
            }
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        router.push(location: "/")
//        if let topVC = self.storyboard?.instantiateViewController(withIdentifier: "TopViewController") {
//            self.changeContent(containerView: self.containerView, childVC: topVC)
//        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    func changeVC(newViewController: UIViewController) {
        let oldVC = self.children.first
        oldVC?.willMove(toParent: nil)
        self.addChild(newViewController)
        self.addSubView(subView: newViewController.view, toView:self.containerView!)
        // TODO: Set the starting state of your constraints here
        newViewController.view.layoutIfNeeded()

        // TODO: Set the ending state of your constraints here

        UIView.animate(withDuration: 0.5, animations: {
                // only need to call layoutIfNeeded here
                newViewController.view.layoutIfNeeded()
            },
            completion: { finished in
                oldVC?.view.removeFromSuperview()
                oldVC?.removeFromParent()
                newViewController.didMove(toParent: self)
        })
    }

    func changeContent(containerView container: UIView, childVC vc: UIViewController) {
        let oldVCs = self.children
        vc.view.translatesAutoresizingMaskIntoConstraints = false
        self.addChild(vc)
        self.addSubView(subView: vc.view, toView: container)

        oldVCs.forEach {
            $0.view.removeFromSuperview()
            $0.removeFromParent()
        }
        vc.didMove(toParent: self)
    }

    func addSubView(subView: UIView, toView parentView:UIView) {
        parentView.addSubview(subView)
        var dict: [String: AnyObject] = [String: AnyObject]()
        dict["subView"] = subView
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "H:|[subView]|", options: [], metrics: nil, views: dict))
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "V:|[subView]|", options: [], metrics: nil, views: dict))
    }
}
