/*
 * Copyright (C) 2016 Felipe Roscoche
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Felipe Roscoche
 * @website roscoche.com
 * 
 */
package imagepatternrecognition;

import java.io.Serializable;
import java.util.Objects;

public class ImageChannel implements Serializable{
    private String imgsrc;
    private String canal;

    public ImageChannel(String imgsrc, String canal) {
        this.imgsrc = imgsrc;
        this.canal = canal;
    }
    public void reset(String imgsrc,String canal){
        this.imgsrc = imgsrc;
        this.canal = canal;
    }
    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public String toString() {
        return "\timgsrc: " + imgsrc + " canal: " + canal+"\t";
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.imgsrc);
        hash = 73 * hash + Objects.hashCode(this.canal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImageChannel other = (ImageChannel) obj;
        if (!Objects.equals(this.imgsrc, other.imgsrc)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        return true;
    }
}
