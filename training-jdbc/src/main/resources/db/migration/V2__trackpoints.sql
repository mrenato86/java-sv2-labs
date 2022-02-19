CREATE TABLE track_points (
    id INT AUTO_INCREMENT,
    tp_time DATE,
    lat DOUBLE(9, 7),
    lon DOUBLE(10, 7),
    activity_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (activity_id) REFERENCES activities(id)
);