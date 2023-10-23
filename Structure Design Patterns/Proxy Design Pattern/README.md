# Proxy Design Pattern

This repository contains an implementation of the Proxy Design Pattern in [programming language of your choice]. The Proxy Design Pattern is a structural pattern that provides a surrogate or placeholder for another object to control access to it.

## Table of Contents

- [Proxy Design Pattern Overview](#proxy-design-pattern-overview)
- [Proxy Types](#proxy-types)
- [How to Use](#how-to-use)
- [Examples](#examples)

## Proxy Design Pattern Overview

The Proxy Design Pattern is used to control access to an object by providing a surrogate or placeholder for it. This can be helpful in various scenarios, such as:

- **Virtual Proxy**: This type of proxy is used to create expensive objects on demand. For example, when loading large files or images, a virtual proxy can be used to delay the creation of the actual object until it is needed.

- **Remote Proxy**: A remote proxy represents an object that is in a different address space. It can be used to manage the interaction with objects that exist on remote servers or services.

- **Cache Proxy**: This type of proxy is used to add caching mechanisms to the actual object's methods. It can store the results of method calls and return them without re-executing the method if the same input is provided.

- **Protection Proxy**: A protection proxy controls access to the real object by checking the permissions of the caller. It can be used to implement access control and security checks.

## Proxy Types

Briefly explain the types of proxies you've implemented in your repository and their use cases.

## How to Use

Provide instructions on how to use the Proxy Design Pattern in your code. Explain how to create and work with proxy objects, and any specific usage details.

```[Include code examples or usage instructions here]```

## Examples
```java
public interface InternetServices {
    String serviceSite(String url);
}

public class Etisalat implements InternetServices {

    private int browsingSpeed=10;

    @Override
    public String serviceSite(String url) {
        return String.format("https://%s.com",url);
    }

    public int getBrowsingSpeed() {
        return browsingSpeed;
    }

    public void setBrowsingSpeed(int browsingSpeed) {
        this.browsingSpeed = browsingSpeed;
    }
}

import java.util.Arrays;
import java.util.List;

public class InternetServicesProxy implements InternetServices{

    List<String> blockedSites= Arrays.asList(
      "porno","facebook","twitter","instagram"
    );

    @Override
    public String serviceSite(String url) {
        if(blockedSites.contains(url)){
            return "this site is blocked, return to work!!!!";
        }
        return new Etisalat().serviceSite(url);
    }

    public void login(String url){
        System.out.printf("[%d] %s %n ",System.currentTimeMillis(),url);
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> sites= Arrays.asList(
                "youtube",
                "linkedin",
                "porno",
                "udemy",
                "facebook",
                "instagram"
        );
        InternetServices internet =new InternetServicesProxy();
        for (String site:sites){
            System.out.println(internet.serviceSite(site));
        }
    }
}



