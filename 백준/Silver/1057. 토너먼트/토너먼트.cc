/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1057                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1057                           #+#        #+#      #+#    */
/*   Solved: 2024/04/24 21:50:50 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <cstdio>

int main (void){
    int n, kim, lim;
    int round = 0;
    
    scanf("%d %d %d", &n, &kim, &lim);
    
    while(kim != lim){
        kim = (kim+1)/2;
        lim = (lim+1)/2;
        round++;
    }
    
    printf("%d\n", round);
}