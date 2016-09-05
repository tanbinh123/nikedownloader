package com.nikedownloader.converter;

import com.garmin.model.tcx.*;
import com.nikeplus.model.json.Activities;
import com.nikeplus.model.json.Activity;
import com.nikeplus.model.json.Datum;
import com.nikeplus.model.json.MetricSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class NikeJsonConverter {

    private static final Logger logger = LoggerFactory.getLogger(NikeJsonConverter.class);

    public static TrainingCenterDatabaseT activitiesJsonToTcx(Activities activities) {
        TrainingCenterDatabaseT trainingCenterDatabaseT = new TrainingCenterDatabaseT();
        ActivityListT activityListT = new ActivityListT();

        for (Datum activity : activities.getData()) {
            buildActivitiesTcx(activityListT, activity);
        }

        trainingCenterDatabaseT.setActivities(activityListT);
        return trainingCenterDatabaseT;
    }

    public static TrainingCenterDatabaseT activityJsonToTcx(Activity activity) {
        TrainingCenterDatabaseT trainingCenterDatabaseT = new TrainingCenterDatabaseT();
        ActivityListT activityListT = new ActivityListT();

        buildActivityTcx(activityListT, activity);

        trainingCenterDatabaseT.setActivities(activityListT);
        return trainingCenterDatabaseT;
    }

    private static void buildActivitiesTcx(ActivityListT activityListT, Datum activity) {
        ActivityT activityT = new ActivityT();
        activityT.setNotes("Notatki");
        activityT.setSport(SportT.RUNNING);

        ActivityLapT activityLapT = new ActivityLapT();
        MetricSummary metricSummary = activity.getMetricSummary();
        activityLapT.setCalories(Integer.parseInt(metricSummary.getCalories()));
        activityLapT.setNotes("Notatka lap");
        activityLapT.setDistanceMeters(Double.parseDouble(metricSummary.getDistance()) * 1000);
        activityLapT.setIntensity(IntensityT.ACTIVE);
        activityLapT.setTriggerMethod(TriggerMethodT.MANUAL);
        try {
            XMLGregorianCalendar value = DatatypeFactory.newInstance().newXMLGregorianCalendar(activity.getStartTime());
            activityLapT.setStartTime(value);
            activityT.setId(value);

        } catch (DatatypeConfigurationException e) {
            logger.info(e.getMessage());
        }
        String[] durationArray = metricSummary.getDuration().split(":");
        double minutes = Double.parseDouble(durationArray[1]);
        double seconds = Double.parseDouble(durationArray[2]);
        activityLapT.setTotalTimeSeconds((60 * minutes) + seconds);
        activityT.getLap().add(activityLapT);
        activityListT.getActivity().add(activityT);
    }

    private static void buildActivityTcx(ActivityListT activityListT, Activity activity) {
        ActivityT activityT = new ActivityT();
        activityT.setNotes("Notatki");
        activityT.setSport(SportT.RUNNING);

        ActivityLapT activityLapT = new ActivityLapT();
        MetricSummary metricSummary = activity.getMetricSummary();
        activityLapT.setCalories(Integer.parseInt(metricSummary.getCalories()));
        activityLapT.setNotes("Notatka lap");
        activityLapT.setDistanceMeters(Double.parseDouble(metricSummary.getDistance()) * 1000);
        activityLapT.setIntensity(IntensityT.ACTIVE);
        activityLapT.setTriggerMethod(TriggerMethodT.MANUAL);
        try {
            XMLGregorianCalendar value = DatatypeFactory.newInstance().newXMLGregorianCalendar(activity.getStartTime());
            activityLapT.setStartTime(value);
            activityT.setId(value);

        } catch (DatatypeConfigurationException e) {
            logger.info(e.getMessage());
        }
        String[] durationArray = metricSummary.getDuration().split(":");
        double minutes = Double.parseDouble(durationArray[1]);
        double seconds = Double.parseDouble(durationArray[2]);
        activityLapT.setTotalTimeSeconds((60 * minutes) + seconds);
        activityT.getLap().add(activityLapT);
        activityListT.getActivity().add(activityT);
    }
}
