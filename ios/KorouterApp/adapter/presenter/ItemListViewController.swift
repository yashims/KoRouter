import Foundation
import UIKit
import KoRouter

class ItemListViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!

    var items: [ItemData] = [
        ItemData(id: 1, name: "item1", price: 100),
        ItemData(id: 2, name: "item2", price: 200),
        ItemData(id: 3, name: "item3", price: 300),
    ]

    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.delegate = self
        tableView.dataSource = self
    }

    class ItemData {
        let id: Int
        let name: String
        let price: Int

        init(id: Int, name: String, price: Int) {
            self.id = id
            self.name = name
            self.price = price
        }
    }
}

extension ItemListViewController: Presenter {
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

extension ItemListViewController: UITableViewDelegate { }

extension ItemListViewController: UITableViewDataSource {
    /// num of rows
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.items.count
    }

    /// make table row cell
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        let item = items[indexPath.row]
        cell.textLabel?.text = "\(item.name): $\(item.price)"
        return cell
    }

    /// on click row
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let item = items[indexPath.row]
        NSLog("item selected: \(item.name)")
        Router.get().back()
    }
}
