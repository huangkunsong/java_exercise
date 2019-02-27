package com.hks.exercise.designPattern.proxy;

import com.hks.exercise.designPattern.proxy.classProxy.Game;
import com.hks.exercise.designPattern.proxy.classProxy.GameProxy;
import com.hks.exercise.designPattern.proxy.interfaceProxy.GamePlayer;
import com.hks.exercise.designPattern.proxy.interfaceProxy.IGamePlayer;
import com.hks.exercise.designPattern.proxy.interfaceProxy.ProxyInterface;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 面向切面编程的底层技术,使用户不用在每个业务点处写入非业务代码,导致逻辑不清晰且导致后期调整要调整多处
 * 动态代理：
 *      代理接口：使用JDK提供的InvocationHander实现
 *      代理类：使用cglib实现
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 基于接口代理
         * 使用Proxy.newProxyInstance生成代理对象
         * 参数：
         *      1：类加载器
         *      2：要代理的接口
         *      3：代理处理程序
         */
        IGamePlayer gamePlayer = new GamePlayer();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(
            gamePlayer.getClass().getClassLoader(),
            new Class[]{IGamePlayer.class},
            new ProxyInterface(gamePlayer));
        proxy.player();

        System.out.println("-------------------------------------------------");

        /**
         * 基于类代理
         * 使用Enhancer生成代理类
         */
        GameProxy gameProxy = new GameProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Game.class);
        enhancer.setCallback(gameProxy);
        Game game = (Game) enhancer.create();
        game.player();

    }
}
