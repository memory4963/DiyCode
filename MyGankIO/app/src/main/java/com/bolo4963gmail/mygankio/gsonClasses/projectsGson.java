package com.bolo4963gmail.mygankio.GsonClasses;

import java.io.Serializable;

/**
 * Created by 10733 on 2017/1/30.
 */

public class ProjectsGson implements Serializable {
    
    /**
     * id : 16938
     * name : GoogleMapsAnimations
     * description : 一个类似 Google 地图的 Android 动画效果开源库
     * readme : [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-GoogleMapsAnimations-green.svg?style=true)](https://android-arsenal.com/details/1/5070)

     # GoogleMapsAnimations

     "GoogleMapsAnimations" is an awesome first of its type android library for showing a ripple and radar animations on a google map, e.g show catchment area of an earthquake where ripples have been felt, give prominence to certain markers which need to be highlighted. Also add a ripple when your user is moving on the map and give a #PokemonGo type ripple effect and also add a radar type effect to show users that you are searching in certain area

     Below samples show the ripple effect in action:

     ![](https://diycode.b0.upaiyun.com/photo/2017/1f7269860f0c828a4bf123382e1a0dfe.gif)![](https://diycode.b0.upaiyun.com/photo/2017/2e9460bb4576ce218d1113b5a3246897.gif)
     ![](https://diycode.b0.upaiyun.com/photo/2017/96106c310fb7c7cc3e30e313c709d2a6.gif)![](https://diycode.b0.upaiyun.com/photo/2017/10b706c75802b02e45acbe02b79f11b9.gif)


     # Download (These are not working for now. Please download the package manually until this issue is resolved)
     ### Using Gradle: under dependencies section:
     ```
     compile 'com.github.aarsy.googlemapsanimations:googlemapsanimations:1.0.3'
     ```
     ### or Using Maven:
     ```
     <dependency>
     <groupId>com.github.aarsy.googlemapsanimations</groupId>
     <artifactId>googlemapsanimations</artifactId>
     <version>1.0.3</version>
     <type>pom</type>
     </dependency>
     ```
     ------

     # Documentation

     ## Ripple Animation

     ### Default Ripple animation
     Just two lines of code :
     Use **.startRippleMapAnimation()** and **.stopRippleMapAnimation()** methods to start and stop Animation.
     Example is given below (Preview shown above in first sample)
     ```
     // mMap is GoogleMap object, latLng is the location on map from which ripple should start

     MapRipple mapRipple = new MapRipple(mMap, latLng, context);
     mapRipple.startRippleMapAnimation();      //in onMapReadyCallBack

     @Override protected void onStop() {
     super.onStop();
     if (mapRipple.isAnimationRunning()) {
     mapRipple.stopRippleMapAnimation();
     }
     }
     // Start Animation again only if it is not running
     if (!mapRipple.isAnimationRunning()) {
     mapRipple.startRippleMapAnimation();
     }

     ```
     ### Advanced Ripple animation

     Example is given below (Preview shown above in second sample)
     ```
     // mMap is GoogleMap object, latLng is the location on map from which ripple should start

     mapRipple = new MapRipple(mMap, latLng, context);
     mapRipple.withNumberOfRipples(3);
     mapRipple.withFillColor(Color.BLUE);
     mapRipple.withStrokeColor(Color.BLACK);
     mapRipple.withStrokewidth(10);      // 10dp
     mapRipple.withDistance(2000);      // 2000 metres radius
     mapRipple.withRippleDuration(12000);    //12000ms
     mapRipple.withTransparency(0.5f);
     mapRipple.startRippleMapAnimation();
     // Use same procedure to stop Animation and start it again as mentioned anove in Default Ripple Animation Sample
     ```
     ### Update center of ripple as location changes(Needed when user moves)
     Just one line of code is needed:
     Use **.mapRipple.withLatLng(LatLng changedLatlng)** method anytime in future to update center of ripple.
     ```
     // after implementing **LocationListener** interface to current class use:
     @Override public void onLocationChanged(Location location) {
     mapRipple.withLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
     }
     //See the sample for more help.

     ```


     ## Radar Animation

     ### Simple Clockwise Radar animation
     Just two lines of code :
     Use **.startRadarAnimation()** and **.stopRadarAnimation()** methods to start and stop Animation.
     Example is given below (Preview shown above in third sample)
     ```
     // mMap is GoogleMap object, latLng is the location on map from which ripple should start

     MapRadar mapRadar = new MapRadar(mMap, latLng, context);
     mapRadar.withDistance(2000);
     mapRadar.withOuterCircleStrokeColor(Color.parseColor("#fccd29"));
     mapRadar.withRadarColors(Color.parseColor("#00fccd29"), Color.parseColor("#fffccd29"));
     //withRadarColors() have two parameters, startColor and tailColor respectively
     //startColor should start with transparency, here 00 in front of fccd29 indicates fully transparent
     //tailColor should end with opaqueness, here f in front of fccd29 indicates fully opaque
     mapRadar.startRadarAnimation();      //in onMapReadyCallBack

     @Override protected void onStop() {
     super.onStop();
     if (mapRadar.isAnimationRunning()) {
     mapRadar.stopRadarAnimation();
     }
     }
     ```


     ### Advanced Clockwise and AntiClockwise Radar animation

     Example is given below (Preview shown above in fourth sample)
     ```
     // mMap is GoogleMap object, latLng is the location on map from which ripple should start

     MapRadar mapRadar = new MapRadar(mMap, latLng, context);
     mapRadar.withDistance(2000);
     mapRadar.withOuterCircleStrokeColor(Color.parseColor("#fccd29"));
     mapRadar.withOuterCircleStrokewidth(7);
     mapRadar.withOuterCircleTransparency(0.4f);
     mapRadar.withClockWiseAnticlockwise(true);		//enable both side rotation
     mapRadar.withClockwiseAnticlockwiseDuration(2);
     //withClockwiseAnticlockwiseDuration(duration), here duration denotes how much cycles should animation makes in
     //one direction
     mapRadar.withOuterCircleFillColor(Color.parseColor("#12000000"));
     mapRadar.withRadarColors(Color.parseColor("#00fccd29"), Color.parseColor("#fffccd29"));
     //withRadarColors() have two parameters, startColor and tailColor respectively
     //startColor should start with transparency, here 00 in front of fccd29 indicates fully transparent
     //tailColor should end with opaqueness, here f in front of fccd29 indicates fully opaque
     mapRadar.withRadarSpeed(5);	//controls radar speed
     mapRadar.withRadarTransparency(0.4f);
     mapRadar.startRadarAnimation();      //in onMapReadyCallBack

     @Override protected void onStop() {
     super.onStop();
     if (mapRadar.isAnimationRunning()) {
     mapRadar.stopRadarAnimation();
     }
     }
     ```
     ### Update center of radar as location changes(Needed when user moves)
     Just one line of code is needed:
     ```
     Use **.mapRadar.withLatLng(LatLng changedLatlng)** method anytime in future to update center of radar.

     // after implementing **LocationListener** interface to current class use:
     @Override public void onLocationChanged(Location location) {
     mapRadar.withLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
     }
     //See the sample for more help.

     ```

     # Compatibility

      **Minimum Android SDK**: This library requires a minimum API level of **11**.

     ------

     # License
     ```
     Copyright 2016 Abhay Raj Singh Yadav(arsy).

     Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions andlimitations under the License.
     ```


      * github : https://github.com/aarsy/GoogleMapsAnimations
      * website :
      * download : https://api.github.com/repos/aarsy/GoogleMapsAnimations/zipball
      * star : 236
      * fork : 45
      * watch : 12
      * project_cover_url : https://diycode.b0.upaiyun.com/developer_user/avatar/2231_1484752188.jpg
      * label_str : radar,multiple
      * category : {"name":"Android","id":1}
      * sub_category : {"name":"动画(Animation)","id":2}
      * last_updated_at : 2017-01-18T21:40:35.000+08:00
     */

    private int id;
    private String name;
    private String description;
    private String readme;
    private String github;
    private String website;
    private String download;
    private int star;
    private int fork;
    private int watch;
    private String project_cover_url;
    private String label_str;
    private CategoryBean category;
    private SubCategoryBean sub_category;
    private String last_updated_at;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description;}

    public String getReadme() { return readme;}

    public void setReadme(String readme) { this.readme = readme;}

    public String getGithub() { return github;}

    public void setGithub(String github) { this.github = github;}

    public String getWebsite() { return website;}

    public void setWebsite(String website) { this.website = website;}

    public String getDownload() { return download;}

    public void setDownload(String download) { this.download = download;}

    public int getStar() { return star;}

    public void setStar(int star) { this.star = star;}

    public int getFork() { return fork;}

    public void setFork(int fork) { this.fork = fork;}

    public int getWatch() { return watch;}

    public void setWatch(int watch) { this.watch = watch;}

    public String getProject_cover_url() { return project_cover_url;}

    public void setProject_cover_url(String project_cover_url) {
        this.project_cover_url = project_cover_url;
    }

    public String getLabel_str() { return label_str;}

    public void setLabel_str(String label_str) { this.label_str = label_str;}

    public CategoryBean getCategory() { return category;}

    public void setCategory(CategoryBean category) { this.category = category;}

    public SubCategoryBean getSub_category() { return sub_category;}

    public void setSub_category(SubCategoryBean sub_category) { this.sub_category = sub_category;}

    public String getLast_updated_at() { return last_updated_at;}

    public void setLast_updated_at(String last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    public static class CategoryBean {

        /**
         * name : Android
         * id : 1
         */

        private String name;
        private int id;

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}
    }

    public static class SubCategoryBean {

        /**
         * name : 动画(Animation)
         * id : 2
         */

        private String name;
        private int id;

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}
    }
}
