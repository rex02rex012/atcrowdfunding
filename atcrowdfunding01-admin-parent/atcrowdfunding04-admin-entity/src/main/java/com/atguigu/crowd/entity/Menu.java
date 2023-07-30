package com.atguigu.crowd.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	// �D��
    private Integer id;

    // ���`�I��id
    private Integer pid;

    // �`�I�W��
    private String name;

    // �`�I���a��URL�a�}�A�O�N���I����涵�ɭn���઺�a�}
    private String url;

    // �`�I�ϼЪ��˦�
    private String icon;
    
    // �s�x�l�`�I�����X�A��l�ƬO���F�קK�ū��w���`
    private List<Menu> children = new ArrayList<Menu>();
    
    // ����`�I�O�_�q�{�����}�ˡA�]�m��true����q�{���}
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