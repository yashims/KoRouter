import Foundation
import korouter

class Router {
    private (set) static var router: KoRouter? = nil

    static func initialize(_ korouter: KoRouter) {
        Router.router = korouter
    }
    static func get() -> KoRouter {
        return router!
    }
}
