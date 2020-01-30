import Foundation
import UIKit

extension UIViewController {
    /// 子VCを変更する。既に子VCが存在すればそれらを消す。つまり、このメソッドを使用する限り、子VCは１つまでしか認められない。
    /// * Parameters:
    ///     * containerView: 子VCのViewを挿入するContainer
    ///     * childVC: 子VC
    func changeContent(containerView container: UIView, childVC vc: UIViewController) {
        let oldVCs = self.children
        vc.view.translatesAutoresizingMaskIntoConstraints = false
        self.addChild(vc)
        self.addSubView(subView: vc.view, toView: container)

        //        vc.view.layoutIfNeeded()
        oldVCs.forEach {
            $0.view.removeFromSuperview()
            $0.removeFromParent()
        }
        vc.didMove(toParent: self)
    }

    /// 親Viewに子Viewを挿入し、範囲いっぱいに広げる制約を付与する。
    func addSubView(subView: UIView, toView parentView:UIView) {
        parentView.addSubview(subView)
        var dict: [String: AnyObject] = [String: AnyObject]()
        dict["subView"] = subView
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "H:|[subView]|", options: [], metrics: nil, views: dict))
        parentView.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "V:|[subView]|", options: [], metrics: nil, views: dict))
    }
}
