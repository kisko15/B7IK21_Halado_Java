package org.example.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
public class ResultDto {

    @XmlElement
    private String name;

    @XmlElement
    private double point;

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }

}
