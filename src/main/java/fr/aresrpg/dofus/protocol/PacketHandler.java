package fr.aresrpg.dofus.protocol;

import fr.aresrpg.dofus.protocol.account.AccountKeyPacket;
import fr.aresrpg.dofus.protocol.account.AccountRegionalVersionPacket;
import fr.aresrpg.dofus.protocol.account.client.*;
import fr.aresrpg.dofus.protocol.account.server.*;
import fr.aresrpg.dofus.protocol.basic.server.BasicConfirmPacket;
import fr.aresrpg.dofus.protocol.hello.server.HelloConnectionPacket;
import fr.aresrpg.dofus.protocol.hello.client.HelloGamePacket;

public interface PacketHandler {
	void register(DofusConnection<?> connection);

	void handle(HelloGamePacket helloGamePacket);

	void handle(HelloConnectionPacket helloConnectionPacket);

	void handle(AccountAuthPacket accountAuthPacket);

	void handle(AccountLoginErrPacket accountLoginErrPacket);

	void handle(AccountLoginOkPacket accountLoginOkPacket);

	void handle(AccountPseudoPacket accountPseudoPacket);

	void handle(AccountCommunityPacket accountCommunityPacket);

	void handle(AccountHostPacket accountHostPacket);

	void handle(AccountQuestionPacket accountQuestionPacket);

	void handle(AccountListServersPacket accountListServersPacket);

	void handle(AccountServerListPacket accountServerListPacket);

	void handle(AccountAccessServerPacket accountAccessServerPacket);

	void handle(AccountServerEncryptedHostPacket accountServerEncryptedHostPacket);

	void handle(AccountServerHostPacket accountServerHostPacket);

	void handle(AccountTicketPacket accountTicketPacket);

	void handle(AccountTicketOkPacket accountTicketOkPacket);

	void handle(BasicConfirmPacket basicConfirmPacket);

	void handle(AccountKeyPacket accountKeyPacket);

	void handle(AccountRegionalVersionPacket accountRegionalVersionPacket);

	void handle(AccountGetGiftsPacket accountGetGiftsPacket);

	void handle(AccountIdentity accountIdentity);

	void handle(AccountGetCharactersPacket accountGetCharactersPacket);

	void handle(AccountCharactersListPacket accountCharactersListPacket);

	void handle(AccountSelectCharacterPacket accountSelectCharacterPacket);
}