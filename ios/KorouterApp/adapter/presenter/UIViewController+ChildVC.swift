import Foundation
import UIKit

extension UIViewController {
    /// Change child VC. if already contain child view remove all subviews.
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

    /// Insert subview into parent, subview expand to fit parent rectangle.
    func addSubView(subView: UIView, toView parentView:UIView) {
        parentView.addSubview(subView)
        var dict: [String: AnyObject] = [String: AnyObject]()
        dict["subView"] = subView
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "H:|[subView]|", options: [], metrics: nil, views: dict))
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "V:|[subView]|", options: [], metrics: nil, views: dict))
    }
}
