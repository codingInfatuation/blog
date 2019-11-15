package per.czt.pojo;

public class Label {
	private Integer label_id;
	private String label_name;
	public Integer getLabel_id() {
		return label_id;
	}
	public void setLabel_id(Integer label_id) {
		this.label_id = label_id;
	}
	public String getLabel_name() {
		return label_name;
	}
	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}
	public Label(Integer label_id, String label_name) {
		super();
		this.label_id = label_id;
		this.label_name = label_name;
	}
	public Label() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
