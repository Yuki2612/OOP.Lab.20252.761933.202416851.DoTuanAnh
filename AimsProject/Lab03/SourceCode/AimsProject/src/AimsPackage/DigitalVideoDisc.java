package AimsPackage;

public class DigitalVideoDisc {
	public void setTitle(String title) {
	    this.title = title;
	}
	
	    private String title;
	    private String category;
	    private String director;
	    public DigitalVideoDisc(String title) {
			super();
			this.title = title;
		}
		public DigitalVideoDisc(String title, String category, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.cost = cost;
		}
		public DigitalVideoDisc(String title, String category, String director, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.director = director;
			this.cost = cost;
		}
		public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.director = director;
			this.length = length;
			this.cost = cost;
		}
		public String getTitle() {
			return title;
		}
		public String getCategory() {
			return category;
		}
		public String getDirector() {
			return director;
		}
		public int getLength() {
			return length;
		}
		public float getCost() {
			return cost;
		}
		private int length;
	    private float cost;
}
