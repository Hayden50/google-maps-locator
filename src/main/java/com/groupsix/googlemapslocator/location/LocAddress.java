package com.groupsix.googlemapslocator.location;

public class LocAddress {

        private String latitude;
        private String longitude;

        public LocAddress(String lat, String lon) {
                latitude = lat;
                longitude = lon;
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

}
