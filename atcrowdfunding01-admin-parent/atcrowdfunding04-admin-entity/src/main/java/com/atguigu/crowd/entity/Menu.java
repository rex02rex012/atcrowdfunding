package com.atguigu.crowd.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	// 主鍵
    private Integer id;

    // 父節點的id
    private Integer pid;

    // 節點名稱
    private String name;

    // 節點附帶的URL地址，是將來點擊菜單項時要跳轉的地址
    private String url;

    // 節點圖標的樣式
    private String icon;
    
    // 存儲子節點的集合，初始化是為了避免空指針異常
    private List<Menu> children = new ArrayList<Menu>();
    
    // 控制節點是否默認為打開裝，設置為true表示默認打開
    private Boolean open = true;
    
    public Menu() {
		// TODO Auto-generated constructor stub
	}

    public Menu(Integer id, Integer pid, String name, String url, String icon, List<Menu> children, Boolean open) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.children = children;
		this.open = open;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", pid=" + pid + ", name=" + name + ", url=" + url + ", icon=" + icon + ", children="
				+ children + ", open=" + open + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}
    
}