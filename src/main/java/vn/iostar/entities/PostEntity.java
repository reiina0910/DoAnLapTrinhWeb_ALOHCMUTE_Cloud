package vn.iostar.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Post")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postid", columnDefinition = "BIGINT")
	private long postID;
	
	@Column(name = "groupid", columnDefinition = "BIGINT")
    private int groupID;
	
	@ManyToOne
    @JoinColumn(name = "userid")
    private UserInfoEntity user;
	
	@Column(name = "content", columnDefinition = "text")
	private String content;
	@Column(name = "image", columnDefinition = "nvarchar(255)")
	private String image;
	@Column(name = "postdate", columnDefinition = "DATE")
	private Date postDate;
	
	 @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	 private List<LikeEntity> listLikes;
	 
	 @OneToMany(mappedBy = "postCommnent", fetch = FetchType.LAZY)
	 private List<CommentsEntity> listComments;
	
	
}