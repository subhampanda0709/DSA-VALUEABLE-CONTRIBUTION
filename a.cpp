#include<bits/stdc++.h>
#include<math.h>
#include<string.h>
#include<cstring>
#include<string>
#include<vector>
#include<stdlib.h>
#include <ext/pb_ds/exception.hpp>
#include <ext/pb_ds/detail/type_utils.hpp>
#include <ext/pb_ds/detail/hash_fn/mask_based_range_hashing.hpp>
#include <ext/pb_ds/detail/hash_fn/mod_based_range_hashing.hpp>
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
#define MOD 1000000007
#define INF 1e18
#define ff first
#define ss second
#define PI 3.141592653589793238462
#define set_bits __builtin_popcountll
#define sz(x) ((int)(x).size())
#define all(x) (x).begin(), (x).end()
#define small 0
const int N = 200005;
#define endl "\n"
using namespace std;
using namespace __gnu_pbds;
#define debug(x) cout << #x << " " << x << endl;
#define debug1(x) cout << #x << " " << x << " ";
typedef long long int ll;
typedef long double lld;
#define timeset ios_base::sync_with_stdio(false),cin.tie(NULL),cout.tie(NULL)
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

/*#define debug(x);
printf(x);*/

void init()
{
  #ifndef ONLINE_JUDGE
  freopen("input.txt" , "r"  ,stdin); 
  freopen("output.txt" , "w" ,stdout);
  #endif
} 

// typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds; // find_by_order, order_of_key

const int MAXN = (int)((1e8) + 100);
ll expo(ll a, ll b, ll mod) {ll res = 1; while (b > 0) {if (b & 1)res = (res * a) % mod; a = (a * a) % mod; b = b >> 1;} return res;}
int modpow(int b, int e){int ans = 1;b %= MOD;while(e){if(e & 1) ans = (ans * b) % MOD;e >>= 1;b = (b * b) % MOD;}return ans;}
int gcd(int a, int b) { if (a == 0) return b; return gcd(b % a, a);}
int max(int a, int b) {if (a > b) return a; else return b;}
int min(int a, int b) {if (a < b) return a; else return b;}
void debug_vector(vector<ll> v){for(auto i:v){cout << i << " ";}}
void debug_map(map<ll,ll> mp){for(auto i:mp){cout << i.ff  << " " << i.ss << endl;}}
void debug_set(set<ll> v){for(auto i:v){cout << i << " ";}}
// vector<ll> sieve(int n) {int*arr = new int[n + 1](); vector<ll> vect; for (int i = 2; i <= n; i++)if (arr[i] == 0) {vect.push_back(i); for (int j = 2 * i; j <= n; j += i)arr[j] = 1;} return vect;}


void precision(int a) 
{
  cout << setprecision(a) << fixed;
}

// {
//  reference
//  cout << "0th element: " << *A.find_by_order(0) << endl;
//  cout << "No. of elems smaller than 6: " << A.order_of_key(6) << endl; // 2
//  cout << "Lower Bound of 6: " << *A.lower_bound(6) << endl;
//  cout << "Upper Bound of 6: " << *A.upper_bound(6) << endl;
// }

//** pritishcf307 **//
//**------------------------------------------------------------------------------------------------------**//
//** code starts here **//



void solve(){
   


}

    

int main(){
  init();
  IOS;
  ll t=1;
  cin >> t;
  while(t--){
      solve();
  }
}
