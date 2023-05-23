package model;

import baseListNode.SingleLinkList;

/// 用来存放个人信息的
public class Person {
    public Person(String phone, String passWord, String nickName) {
        this.phone = phone;
        this.passWord = passWord;
        this.nickName = nickName;
    }

    /// 手机号
    public String phone;

    /// 密码
    public String passWord;

    /// 昵称
    public String nickName;
}