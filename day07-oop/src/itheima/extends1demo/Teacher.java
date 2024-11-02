package itheima.extends1demo;

import com.itheima.extends1demo.People;

// 子类
public class Teacher extends People {
    private String skill; // 技术。

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
