import Foundation
import UIKit
import KoRouter

class TopViewController: UIViewController {
    @IBAction func onClickShowList(_ sender: Any) {
        Router.get().push(location: "/list")
    }
}

extension TopViewController: Presenter {
    func onSwapInChild(name: String?, child: Presenter?, args: [String : String]?) {
        guard let _child = child as? UIViewController else {
            NSLog("\(type(of: self)) swap in child: (name:\(name ?? "null"), child:null)")
            return
        }
        NSLog("\(type(of: self)) swap in child: (name:\(name ?? "null"), child:\(_child))")
    }

    func onSwapOutChild(name: String?, child: Presenter?) {
        guard let _child = child as? UIViewController else {
            NSLog("\(type(of: self)) swap out child: (name:\(name ?? "null"), child:null)")
            return
        }
        NSLog("\(type(of: self)) swap out child: (name:\(name ?? "null"), child:\(_child))")
    }
}
