import Foundation

@objc public class Prisma: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
