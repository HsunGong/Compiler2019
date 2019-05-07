package mxcompiler.utils;

public interface Dump {

	public void addTab();

	public void delTab();

	public String getTab();

	public void println(String x);

	public void printf(String format, Object... args);

	public void print(String str);
}