package com.groupsix.googlemapslocator.location;

public class LocAddress {

        private String latitude;
        private String longitude;
        private String radius;

        public LocAddress(String lat, String lon, String rang) {
                latitude = lat;
                longitude = lon;
                radius = rang;
        }

        public void setLatitude(String lat) {
                latitude = lat;
        }

        public void setLongitude(String lon) {
                longitude = lon;
        }

        public String getLatitude() {
                return latitude;
        }

        public String getLongitude() {
                return longitude;
        }

        public String getRadius() {
                return this.radius;
        }

        public void setRadius(String radius) {
                this.radius = radius;
        }

}
