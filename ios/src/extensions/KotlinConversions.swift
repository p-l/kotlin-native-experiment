import Foundation
import core

extension Int {
    func toKotlinInt() -> KotlinInt {
        return KotlinInt(integerLiteral: self)
    }
    
    func toKotlinUInt() -> KotlinUInt {
        return KotlinUInt(integerLiteral: self)
    }
}

extension KotlinInt {
    func toInt() -> Int {
        return Int(truncating: self)
    }
}

extension Int32 {
    func toInt() -> Int {
        return Int(self)
    }
}

extension Double {
    func toKotlinDouble() -> KotlinDouble {
        return KotlinDouble(double: self)
    }
}

extension KotlinDouble {
    func toDouble() -> Double {
        return Double(self.doubleValue)
    }
}


