package tikitaka;

/////////////�ּ� ����/////////////
/* �ش� �ڵ忡 ���� ������ //�� �ּ�ó��
 * �ش� �κп� �����ؾ� �� �ڵ� ������ ////�� �ּ�ó��
 * GUI ���� ��û�� ///GUI///�� �ּ�ó��
 * ���� ���� ��û�� ///SOCKET///�� �ּ�ó��
 */

public class tikitaka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Game{
	//���� �ִ� ����
	
	int[] block_order = new int[9]; //ó�� ������ ���� ���� �� ������ ���� �迭
	Block[] block;
	int num_block; //�����ִ� �� ����
	Player player1;
	Player player2;
	
	Game() {
		//������ => init ����
		
		//block_order�� �������� 0~8 ���� �־��ֱ�
		////�����Լ� �Ἥ this.block_order =
		
		//block 9���� ���� �־��ֱ� �� ���� ����, ���� ������ ������ ����
		this.block = new Block[9];
		this.block[0] = new Block("red", block_order[0]);
		this.block[1] = new Block("orange", block_order[0]);
		this.block[2] = new Block("yellow", block_order[0]);
		this.block[7] = new Block("green", block_order[0]);
		this.block[3] = new Block("sky", block_order[0]);
		this.block[4] = new Block("blue", block_order[0]);
		this.block[5] = new Block("purple", block_order[0]);
		this.block[6] = new Block("pink", block_order[0]);
		this.block[8] = new Block("gray", block_order[0]);
		
		//player 2�� ����
		this.player1 = new Player();
		this.player2 = new Player();
		
		//�����ǿ� �����ִ� �� ����
		this.num_block = 9;
		
		///GUI///���� �ʱ� ȭ�� �־��ֱ�
	}

	void gameOver() {
		//2���� player�� ī�带 ��� ���� ���� ����
		if(player1.action_card.num_card == 0 & player2.action_card.num_card == 0)
		{
			//player ���� ����ϱ�
			player1.calculation(this, player1.score);
			player2.calculation(this, player2.score);
			//���� ����
			///GUI///�������� �־��ֱ�
			///GUI///�� player�� ���� ���
		}
	}
	
}

class Player {
	//������
	
	ActionCard action_card; //player�� �׼�ī��
	int score; //����
	MissonCard misson = new MissonCard(); //������ �ִ� �̼� ī�� ; �����ڷ� �������� �ϳ� �����Բ�
	///GUI///�⺻�� �׳� ī�� ���� �׸��̾��ٰ� ��ư ������ �̼�ī�� ���̰Բ� �ϸ� ���� �� ������, �̰� ��� �ؾ��ұ�
	
	void calculation(Game game, int score) {
		//���� ��� �� player�� score ������Ʈ
		//�������� �̼�ī���� 1,2,3�� ������� ���ӿ� �����ϴ� 1,2,3�� ������ ��
		Block temp = new Block();
		for( int i=0 ; i<9 ; i++)
		{
			//�����ǿ��� 1���� ���� ���� player�� �̼�ī���� 1�� ���� ������ 7�� �ο�
			if(game.block[i].order == 1) {
				temp = game.block[i];
				if(	this.misson.first_color == temp.color) { 
					this.score += 7; 
				}
			}
			//�����ǿ��� 2���� ���� ���� player�� �̼�ī���� 1�� �Ǵ� 2�� ���� ������ 5�� �ο�
			else if(game.block_order[i] == 2)
			{
				temp = game.block[i];
				if( this.misson.second_color == temp.color) {
					this.score += 5;
				}
				else if(this.misson.first_color == temp.color) {
					this.score += 5;
				}
			}
			//�����ǿ��� 2���� ���� ���� player�� �̼�ī���� 1��,2��,3�� ���� ������ 5�� �ο�
			else if(game.block_order[i] == 3)
			{
				temp = game.block[i];
				if( this.misson.third_color == temp.color) {
					this.score += 3;
				}
				else if(this.misson.first_color == temp.color) {
					this.score += 3;
				}
				else if(this.misson.second_color == temp.color) {
					this.score += 3;
				}
			}
		}
	}
	//������ : ó�� ��ü ���� �� �⺻ ����
	Player() { this.action_card = new ActionCard(); this.score = 0; }
	
}

class Block {
	//����
	
	String color = new String(); //�� ����
	int order; //�� ����(1~9)
	boolean exist; //�����ǿ� �����ִ��� Ȯ��
	
	Block() {}
	//�� ��° ������: ��ü ó���� ������ �� �������� ���� ������ �÷��� �־ ���� �����ϱ�
	Block(String color, int order) { this.color = color; this.order = order; this.exist = true;	}
	///GUI/// ���� �Ű������� ������ �� ��Ͽ� �ش��ϴ� �̹����� ����ó�� ������ �ְ� �� �� �ֳ�?
}

class MissonCard {
	//�̼�ī��
	
	//�ڽ��� �̼� ����
	String first_color;
	String second_color;
	String third_color;
	
	////�����ڷ� �������� �̾Ƽ� �־��ֱ�
	MissonCard() {
		
	}
	
	///GUI/// �굵 �� ���� ���� ������ �׿� �ش��ϴ� �̹����� ����ó�� ������ �ְ� �� �� �ֳ�?
}

class ActionCard {
	//7���� �׼�ī��
	int num_card; //���� �׼� ī�� ��
	///GUI/// ȭ�� �� ���� �ִ� ī�� ���̰Բ�
	Block choose_block; //������ �� ��ü
	
	void next_turn() {
		////���� �÷��̾� ������ �Ѿ��
		///GUI///�ε� � �÷��̾� �������� ǥ�����ֱ�
		
	} 
}

class RemoveCard extends ActionCard {
	//������ ��� ������
	
	RemoveCard() { this.num_card = 2; } //ó���� �־��� ī�� 2��
	
	void removeCard(Game game) {
		//������ ��� ������, �̶� choose�� game�� ������ �� �־������
		for(int i=0;i<game.num_block;i++)
		{
			if(game.block[i].order == game.num_block) //������������� Ȯ��
			{
				choose_block.exist = false; //�ش� ��� ������
				this.num_card --; //�ش� �׼� ī�� ���� -1
				///GUI///�ٲ� ���� �����ִ� �׼�ī�� �ݿ�
				this.next_turn(); //���� �÷��̾�� �Ѿ��
			}
		}
	}
	
	boolean possible() { 
		//�� �׼� ī�� ��� �������� Ȯ�� �� ���� 
		if(this.num_card > 0) //�����ִ� ī������ Ȯ��
			return true; 
		else return false;
		//��� ������ ��Ҵ� �׻� true
		} 
}

class DownCard extends ActionCard {
	//������ ��� ���������� ������
	
	DownCard() {this.num_card = 1; } //ó���� �־��� ī�� 1��
	
	///GUI/// �̶� ȭ�鿡�� Ŭ���� ���� Block������ choose_block �Ű������� ���Բ� �� �� �ֳ�?
	void downCard(Game game, Block choose_block) {
		//������ ��� ������ ������ �ٲٱ�, ������ ��� �Ű�������
		int choose_block_order = choose_block.order;
		for(int i=0;i<game.num_block;i++) {
			//������ ��� �Ʒ� �ִ� �͵� �� ĭ�� ����
			if(game.block[i].order > choose_block_order) {
				game.block[i].order++;
			}
			//������ ��� �� �Ʒ���
			if(game.block[i].order == choose_block_order) {
				game.block[i].order = game.num_block;
			}
		}
		this.num_card --; //�ش� �׼� ī�� ���� -1
		///GUI///�ٲ� ���� �����ִ� �׼�ī�� �ݿ�
		this.next_turn(); //���� ������ �Ѿ��
	}
	
	boolean possible() { 
		if(this.num_card > 0) //�����ִ� ī������ Ȯ��
			return true; 
		else return false; } //��� ������ ��Ҵ� �׻� true
}

class UpOne extends ActionCard {
	//������ ��� ���� 1ĭ �ø���
	
	UpOne() { this.num_card = 2; } //ó���� �־��� ī�� 2��
	
	///GUI/// �̶� ȭ�鿡�� Ŭ���� ���� Block������ choose_block �Ű������� ���Բ� �� �� �ֳ�?
	void upOne(Game game, Block choose_block) {
		//������ ��� ���� 1ĭ �ø���
		int choose_block_order = choose_block.order;
		for(int i=0;i<game.num_block;i++) {
			//������ ��� ���� ��� �� ĭ �Ʒ���
			if(game.block[i].order == choose_block_order+1) {
				game.block[i].order--;
			}
			//������ ��� ��ĭ ����
			if(game.block[i].order == choose_block_order) {
				game.block[i].order++;
			}
		}
		this.num_card --; //�ش� �׼� ī�� ���� -1
		///GUI///�ٲ� ���� �����ִ� �׼�ī�� �ݿ�
		this.next_turn(); //���� ������ �Ѿ��
	}
	
	boolean possible() {
		//������ �������� Ȯ�� �� ����
		if(this.num_card > 0) {
			if(choose_block.order > 1) {
			//���� ����� ������ 1���� ū��
			return true;
			}
			else return false;
		}
		else return false;
	}
}
class UpTwo extends ActionCard {
	//������ ��� ���� 2ĭ �ø���
	
	UpTwo() { this.num_card = 1; } //ó���� �־��� ī�� 1��
	
	///GUI/// �̶� ȭ�鿡�� Ŭ���� ���� Block������ choose_block �Ű������� ���Բ� �� �� �ֳ�?
	void upTwo(Game game, Block choose_block) {
		//������ ��� ���� 2ĭ �ø���
		int choose_block_order = choose_block.order;
		for(int i=0;i<game.num_block;i++) {
		//������ ��� ���� �� ��� �� ĭ�� �Ʒ���
			if(game.block[i].order == choose_block_order+1 | game.block[i].order == choose_block_order+2) {
				game.block[i].order--;
			}
			//������ ��� 2ĭ ����
			if(game.block[i].order == choose_block_order) {
				game.block[i].order = game.block[i].order+2;
			}
		}
		this.num_card --; //�ش� �׼� ī�� ���� -1
		///GUI///�ٲ� ���� �����ִ� �׼�ī�� �ݿ�
		this.next_turn(); //���� ������ �Ѿ��
	}
		
	boolean possible() {
		//������ �������� Ȯ�� �� ����
		if(this.num_card > 0) {
			if(choose_block.order > 2) {
			//���� ����� ������ 2���� ū��
			return true;
			}
			else return false;
		}
		else return false;
	}
}
class UpThree extends ActionCard {
	//������ ��� ���� 3ĭ �ø���
	
	UpThree() { this.num_card = 1; } //ó���� �־��� ī�� 1��
	
	///GUI/// �̶� ȭ�鿡�� Ŭ���� ���� Block������ choose_block �Ű������� ���Բ� �� �� �ֳ�?
	void upThree(Game game, Block choose_block) {
		//������ ��� ���� 3ĭ �ø���
		int choose_block_order = choose_block.order;
		for(int i=0;i<game.num_block;i++) {
			//������ ��� ���� �� ��� �� ĭ�� �Ʒ���
			if(game.block[i].order >= choose_block_order+1 & game.block[i].order <= choose_block_order+3) {
				game.block[i].order--;
			}
			//������ ���  3ĭ ����
			if(game.block[i].order == choose_block_order) {
				game.block[i].order = game.block[i].order+3;
			}
		}
		this.num_card --; //�ش� �׼� ī�� ���� -1
		///GUI///�ٲ� ���� �����ִ� �׼�ī�� �ݿ�
		this.next_turn(); //���� ������ �Ѿ��
	}
	
	boolean possible() {
		//������ �������� Ȯ�� �� ����
		if(this.num_card > 0) {
			if(choose_block.order > 3) {
			//���� ����� ������ 3���� ū��
			return true;
			}
			else return false;
		}
		else return false;
	}
}

