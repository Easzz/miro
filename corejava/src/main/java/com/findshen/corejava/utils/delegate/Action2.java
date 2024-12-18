package com.findshen.corejava.utils.delegate;

import java.util.function.BiConsumer;

/**
 * @Author: 李溪林
 * @Descriptions: 带2个参数的无返回类型委托
 * @CreateDate: 17-2-20
 */
public class Action2<T1, T2> {

	/**
	 * 委托对象
	 */
	private BiConsumer<T1, T2> consumer;

	/**
	 * 构造
	 *
	 * @param consumer 委托对象
	 */
	public Action2(BiConsumer<T1, T2> consumer) {
		this.consumer = consumer;
	}

	/**
	 * 执行委托
	 *
	 * @param t1 执行参数
	 * @param t2 执行参数
	 */
	public void invoke(T1 t1, T2 t2) {
		if (this.consumer != null) {
			consumer.accept(t1, t2);
		}
	}

	public static void main(String[] args) {
		//构造具体的逻辑
		Action2<Integer, Integer> action2 = new Action2<>((a, b) -> System.out.println(a + b));
		//提供参数执行逻辑
		action2.invoke(1, 2);
	}
}
