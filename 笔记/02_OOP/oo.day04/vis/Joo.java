package oo.day04.vis;
import oo.day04.Hoo;

public class Joo { //演示同包
	void show(){
		Hoo o = new Hoo();
		o.a = 1;
		//o.b = 2;
		//o.c = 3;
		//o.d = 4;
	}
}

class Koo extends Hoo{ //演示protected
	void show(){
		a = 1;
		b = 2;
		//c = 3;
		//d = 4;
	}
}











