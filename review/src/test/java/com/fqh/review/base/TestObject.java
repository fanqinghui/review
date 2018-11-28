package com.fqh.review.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fqh
 * @Description: java类，equle与hashcode需要一起重写
 * @date 2018/11/28上午10:55
 */
public class TestObject {

    /**
     * 纯粹的对象之间判断
     */
    @Test
    public void testEqule(){
        Student stu1=new Student("小明");
        Student stu2=new Student("小明");
        System.out.println(stu1);
        System.out.println(stu2);
        boolean result=stu1==stu2;
        stu1.notify();
        Assert.assertFalse(result);
    }

    /**
     * 对象之间判断，对象自己实现了equle,与hashcode
     */
    @Test
    public void testEqule2(){
        Student2 stu1=new Student2("小明");
        Student2 stu2=new Student2("小明");
        System.out.println(stu1);
        System.out.println(stu2);
        boolean result=stu1==stu2;
        Assert.assertFalse(result);
        Assert.assertEquals(stu1,stu2);
    }

}

class Student{
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student2 extends Student{
    public Student2() {
    }

    public Student2(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object obj) {
        Student2 student2=(Student2)obj;
        if(student2.getName().equals(this.getName())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                '}'+"hashcode:"+this.hashCode();
    }
}
