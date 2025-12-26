//
//  greeting.swift
//  
//
//  Created by Harrison Egerton on 12/26/25.
//

public func greeting() -> () {
    print("Hello, world!");
}

public func greeting(name: String) -> () {
    print("Hello, \(name)!");
}

public func greetWithName() -> () {
    print("What is your name?" )
    if let name = readLine() {
        greeting(name:name)
    }
}
