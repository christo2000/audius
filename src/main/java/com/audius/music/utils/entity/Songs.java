package com.audius.music.utils.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "songs", schema = "tracks")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "track_id", nullable = true)
    private Long trackId;
    @Column(name = "track_path", length = 10000, nullable = true)
    private String trackPath;
}
