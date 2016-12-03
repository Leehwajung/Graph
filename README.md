#Graph
Algorithm Course - Graph Assignment and Quiz

Language:	Java<br>
IDE:		Eclipse

##Assignment
**알고리즘 프로그래밍 숙제**

1. 그래프를 Adjacent List를 이용하여 다음과 같은 형태로 파일로부터 읽어 들인다.<br>
    1  3 4 5¶<br>
    2  4 5¶<br>
    3  6 7 8 9¶

2. DFS 알고리즘을 이용하여 DFS Tree를 출력한다. 출력된 그래프는 다음와 같은 형태로 한다.
    - A Tree<br>
    　　　　　　　　A<br>
    　　　B　　　　　C　　　　　1<br>
    　C　　　1　　1　　　2<br>
    1　2
    
    - Preorder Depth First Search<br>
    A<br>
    •  B<br>
    •  •  C<br>
    •  •  •  1<br>
    •  •  •  2<br>
    •  •  1<br>
    •  C<br>
    •  •  1<br>
    •  •  2<br>
    •  1
    
    - Breadth First Search<br>
    A<br>
    •  B<br>
    •  C<br>
    •  1<br>
    •  •  C<br>
    •  •  1<br>
    •  •  1<br>
    •  •  2<br>
    •  •  •  1<br>
    •  •  •  2<br>
    
3. 만약 그래프의 Tree가 여러 개이면 여러 개의 Tree를 모두 출력한다.

4. 위의 그래프의 각 노드에 Discover Time과 Finish Time을 출력한다.
    - Preorder Depth First Search<br>
    A (1/8)<br>
    •  B (2/5)<br>
    •  •  C<br>
    •  •  •  1<br>
    •  •  •  2<br>
    •  •  1<br>
    •  C<br>
    •  •  1<br>
    •  •  2<br>
    •  1