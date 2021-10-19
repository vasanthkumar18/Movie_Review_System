# MOVIE REVIEW SYSTEM
**PROJECT**: *A java code for the movie review service. The program collects reviews for movies from its users and implements many more features.*
<br/>
<br/>
Everyone needs to find a system and framework that works for them. This isn’t just pragmatics; this is an exhortation to do work of figuring out your own tastes and learning how to thoughtfully expand them. As someone who has built a reputation for my love of film and faith, I’ve recognized that I need to have a sort of public framework, a movie ratings system.
<br/>
<br/>
![Review System](https://www.feedbackexpress.com/wp-content/uploads/2018/05/amazon-product-reviews-guide.jpg)
<br/>
<br/>

> This program is entirely coded in JAVA

**OVERVIEW**
The movie review service collects reviews for movies from its users. Later these
movie reviews are used to derive insights which helps in enriching the lives of its
customers with entertainment.


**Internal Capabilities**
1. Users of the service can review only movies which are released so far, they
cannot review upcoming movies.
2. Users can give a review-score between 1 to 10. (Higher the score the better
the liking for the movie). Currently we are not allowing a user to review the
same movie multiple times.
3. The service by default on-boards a user as a ‘viewer’. Later a ‘viewer’ can
be upgraded to a ‘critic’ after he/she has published more than 3 reviews
for various movies.
4. Critics are considered as experts in the judgement here, so critics reviews
will be captured with more weightage. i.e. 6 review rating of a critic will be
considered as 12 (2x) NOTE: Older reviews by the user as `viewer` shall not
be affected.

**The following features are available in this program:**
1. Adding users and movies.
2. User to review a movie.
3. List top n movies by total review score by ‘critics’ in a particular genre.
4. Average review score in a particular year of release.
5. Average review score for a particular movie
