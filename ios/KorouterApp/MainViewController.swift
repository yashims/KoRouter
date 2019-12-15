import UIKit
import korouter

class MainViewController: UIViewController, Presenter {
    @IBOutlet weak var containerView: UIView!

    func onSwapInChild(name: String?, child: Presenter?, args: [String : String]?) {
        NSLog("swap in")
    }

    func onSwapOutChild(name: String?, child: Presenter?) {
        NSLog("swap out")
    }

    lazy var router: KoRouter = KoRouter.Companion().invoke {
        $0.route(path: "/") {
            $0.name = "index"
            $0.component = self as Presenter
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()

//        let queue = DispatchQueue.global(qos: .userInitiated)
//        let group = DispatchGroup()
//        queue.async(group: group) {
//            sleep(3)
//        }
//        group.notify(queue: DispatchQueue.main) {
//            self.changeVC(newViewController: TopViewController())
//        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    func addSubview(subView:UIView, toView parentView:UIView) {
        parentView.addSubview(subView)

        var viewBindingsDict = [String: AnyObject]()
        viewBindingsDict["subView"] = subView
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "H:|[subView]|",
            options: [], metrics: nil, views: viewBindingsDict))
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "V:|[subView]|",
            options: [], metrics: nil, views: viewBindingsDict))
    }

    func cycleFromViewController(oldViewController: UIViewController, toViewController newViewController: UIViewController) {
        oldViewController.willMove(toParent: nil)
        self.addChild(newViewController)
        self.addSubview(subView: newViewController.view, toView:self.containerView!)
        // TODO: Set the starting state of your constraints here
        newViewController.view.layoutIfNeeded()

        // TODO: Set the ending state of your constraints here

        UIView.animate(withDuration: 0.5, animations: {
            // only need to call layoutIfNeeded here
            newViewController.view.layoutIfNeeded()
        },
                       completion: { finished in
                        oldViewController.view.removeFromSuperview()
                        oldViewController.removeFromParent()
                        newViewController.didMove(toParent: self)
        })
    }

    func changeVC(newViewController: UIViewController) {
        let oldVC = self.children.first
        oldVC?.willMove(toParent: nil)
        self.addChild(newViewController)
        self.addSubview(subView: newViewController.view, toView:self.containerView!)
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
}
