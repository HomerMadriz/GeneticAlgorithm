package TestGAVA;

public class RouteMap<Type> {
	private Type[][] map;
	private int nodes;
	
	public RouteMap(int nodes) {
		this.nodes = nodes;
	}
	
	public void mapCreate() {
		
	}
	
	public Type[][] getMap(){
		return map;
	}
	
}
