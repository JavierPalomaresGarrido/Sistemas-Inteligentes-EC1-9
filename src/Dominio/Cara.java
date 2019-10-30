package Dominio;

	public enum Cara {
		UP(0),
		DOWN (1),
		FRONT(2),
		BACK (3),
		LEFT(4),
		RIGHT(5);

	    private final int cara;
	    
	    private Cara(int cara) {
	        this.cara=cara;
	     }
	    public int cara() { return cara; }
	    
}
