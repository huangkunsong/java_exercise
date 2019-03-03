package com.hks.exercise.designPattern.state;
/**
 * 状态模式（状态对象模式）：
 *      状态模式允许一个对象在其内部状态改变的时候改变其行为,这个对象看起来改变了其类。
 *      状态模式把所研究的对象的行为包装在不同的状态对象里，
 *      每一个状态对象都属于一个抽象状态类的一个子类。
 *      状态模式的意图是让一个对象在其内部状态改变的时候，其行为也随之改变。
 *  环境(Context)角色,也成上下文：
 *              定义客户端所感兴趣的接口,并且保留一个具体状态类的实例.
 *              这个具体状态类的实例给出此环境对象的现有状态。
 *  抽象状态(State)角色： 定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
 *  具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 *  优点：
 *      1：结构清晰,避免了过多使用switch..case或者if..else
 *      2：符合开闭原则和单一职责,每个状态都是一个子类,你要增加状态就要增加子类,你要修改状态就修改一个子类就可以
 *      3：封装性好,外部不知道内部状态的变化。
 *  缺点：
 *      子类太多,一个状态一个子类。
 *
 *  使用场景：
 *      1：行为随状态的改变而改变的场景。
 *      2：条件、分支判断语句的代替者。
 */
public class Main {
    public static void main(String[] args) {
        LiftManager liftManager = new LiftManager();
        liftManager.setLiftState(new OpenState());
        liftManager.run();
        liftManager.close();
        liftManager.run();
        liftManager.close();
        liftManager.stop();
    }
}
