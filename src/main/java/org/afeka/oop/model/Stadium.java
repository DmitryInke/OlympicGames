package org.afeka.oop.model;

public class Stadium {
    private Integer sid = null;
    private final String name;
    private final String address;
    private final int capacity;

    public Stadium(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Stadium))
            return false;
        Stadium temp = (Stadium) other;
        return name.equalsIgnoreCase(temp.name) && address.equalsIgnoreCase(temp.address);
    }

    @Override
    public String toString() {
        return "Stadium " + name + ", address: " + address + ", capacity: " + capacity + "";
    }

}
