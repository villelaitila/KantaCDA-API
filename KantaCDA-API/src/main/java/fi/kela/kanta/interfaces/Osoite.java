<!--
  Copyright 2020 Kansaneläkelaitos
  
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License.  You may obtain a copy
  of the License at
  
    http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
  License for the specific language governing permissions and limitations under
  the License.
-->
package fi.kela.kanta.interfaces;

import java.io.Serializable;

public interface Osoite extends Serializable {

    public String getKatuosoite();

    public void setKatuosoite(String katuosoite);

    public String getMaa();

    public void setMaa(String maa);

    public String getPostinumero();

    public void setPostinumero(String postinumero);

    public String getPostitoimipaikka();

    public void setPostitoimipaikka(String postitoimipaikka);
}
