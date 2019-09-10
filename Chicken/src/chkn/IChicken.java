package chkn;

public interface IChicken {
	
	public void move_left();
	public void move_right();
	public void move_up();
	public void move_down();
	public int[] fire();
	public void change_direction(int direction);
	public int[] get_location();
	public void hit(int damage);
	public boolean is_alive();
	public int set_vars(int min, int max,int var);

}
