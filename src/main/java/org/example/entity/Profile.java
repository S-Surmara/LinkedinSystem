package org.example.entity;

public class Profile {
    private String uuid;
    private String name;
    private String summary;
    private String experience;

    public Profile(String uuid, String name, String summary, String experience) {
        this.uuid = uuid;
        this.name = name;
        this.summary = summary;
        this.experience = experience;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
