package ru.kuzhleva.lab5.stream;

import java.util.Comparator;
import java.util.List;

public class PolylineBuild {

    public static Polyline buildPolyline(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("Массив с элементами не может быть пустым.");
        } else {
            Point[] result = points.stream()
                    .map(p -> new Point(p.getCoordinateX(), Math.abs(p.getCoordinateY())))
                    .distinct()
                    .sorted(Comparator.comparing(Point::getCoordinateX))
                    .toArray(Point[]::new);
            return new Polyline(result);
        }
    }
}
